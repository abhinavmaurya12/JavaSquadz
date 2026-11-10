import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Query01 - A small JDBC database workbench.
 *
 * Java 8+ (including Java 21).
 * A JDBC driver for your database must be added to the classpath.
 *
 * Example URLs:
 *   MySQL:      jdbc:mysql://localhost:3306/your_database
 *   PostgreSQL: jdbc:postgresql://localhost:5432/your_database
 *   Oracle XE:  jdbc:oracle:thin:@localhost:1521:XE
 *   SQL Server: jdbc:sqlserver://localhost:1433;databaseName=your_database;encrypt=true;trustServerCertificate=true
 */
public class Query01_t4 extends JFrame {
    private JTextField urlField;
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton connectButton;
    private JButton disconnectButton;

    private JComboBox<TableInfo> tableCombo;
    private JList<String> columnList;
    private JTextField whereField;
    private JTextField orderByField;
    private JTextArea sqlArea;
    private JTable resultTable;
    private JLabel statusLabel;

    private Connection connection;
    private DatabaseMetaData metadata;

    public Query01_t4() {
        super("Query01 - JDBC Database Workbench");
        buildUI();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1050, 700);
        setLocationRelativeTo(null);
    }

    private void buildUI() {
        JPanel root = new JPanel(new BorderLayout(8, 8));
        root.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setContentPane(root);

        JPanel connectionPanel = new JPanel(new GridBagLayout());
        connectionPanel.setBorder(BorderFactory.createTitledBorder("Database Connection"));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4, 5, 4, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        urlField = new JTextField("jdbc:mysql://localhost:3306/your_database", 42);
        userField = new JTextField("root", 14);
        passwordField = new JPasswordField(14);
        connectButton = new JButton("Connect");
        disconnectButton = new JButton("Disconnect");
        disconnectButton.setEnabled(false);

        addGrid(connectionPanel, c, 0, 0, new JLabel("JDBC URL:"));
        addGrid(connectionPanel, c, 1, 0, urlField);
        addGrid(connectionPanel, c, 2, 0, new JLabel("Username:"));
        addGrid(connectionPanel, c, 3, 0, userField);
        addGrid(connectionPanel, c, 4, 0, new JLabel("Password:"));
        addGrid(connectionPanel, c, 5, 0, passwordField);
        addGrid(connectionPanel, c, 6, 0, connectButton);
        addGrid(connectionPanel, c, 7, 0, disconnectButton);

        root.add(connectionPanel, BorderLayout.NORTH);

        JPanel workPanel = new JPanel(new BorderLayout(8, 8));
        JPanel leftPanel = new JPanel(new BorderLayout(5, 5));
        leftPanel.setPreferredSize(new Dimension(250, 400));
        leftPanel.setBorder(BorderFactory.createTitledBorder("Tables and Columns"));

        tableCombo = new JComboBox<>();
        columnList = new JList<>();
        columnList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        leftPanel.add(new JLabel("Table:"), BorderLayout.NORTH);
        JPanel tableAndColumns = new JPanel(new BorderLayout(4, 4));
        tableAndColumns.add(tableCombo, BorderLayout.NORTH);
        tableAndColumns.add(new JScrollPane(columnList), BorderLayout.CENTER);
        leftPanel.add(tableAndColumns, BorderLayout.CENTER);

        JButton selectAllButton = new JButton("Select All Columns");
        leftPanel.add(selectAllButton, BorderLayout.SOUTH);

        JPanel rightPanel = new JPanel(new BorderLayout(6, 6));
        JPanel queryOptions = new JPanel(new GridBagLayout());
        queryOptions.setBorder(BorderFactory.createTitledBorder("Query Options"));
        GridBagConstraints q = new GridBagConstraints();
        q.insets = new Insets(4, 5, 4, 5);
        q.fill = GridBagConstraints.HORIZONTAL;
        q.weightx = 0;
        addGrid(queryOptions, q, 0, 0, new JLabel("WHERE condition:"));
        whereField = new JTextField(35);
        whereField.setToolTipText("Example: id > 10  (do not type the WHERE keyword)");
        q.weightx = 1;
        addGrid(queryOptions, q, 1, 0, whereField);
        q.weightx = 0;
        addGrid(queryOptions, q, 0, 1, new JLabel("ORDER BY:"));
        orderByField = new JTextField(35);
        orderByField.setToolTipText("Example: id DESC");
        q.weightx = 1;
        addGrid(queryOptions, q, 1, 1, orderByField);

        JPanel sqlPanel = new JPanel(new BorderLayout(4, 4));
        sqlPanel.setBorder(BorderFactory.createTitledBorder("SQL (you can edit this query)"));
        sqlArea = new JTextArea(5, 60);
        sqlArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        JButton buildButton = new JButton("Build SELECT");
        JButton executeButton = new JButton("Execute SQL");
        JPanel sqlButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        sqlButtons.add(buildButton);
        sqlButtons.add(executeButton);
        sqlPanel.add(new JScrollPane(sqlArea), BorderLayout.CENTER);
        sqlPanel.add(sqlButtons, BorderLayout.SOUTH);

        resultTable = new JTable();
        resultTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane resultScroll = new JScrollPane(resultTable);
        resultScroll.setBorder(BorderFactory.createTitledBorder("Query Results"));

        rightPanel.add(queryOptions, BorderLayout.NORTH);
        JPanel center = new JPanel(new BorderLayout(5, 5));
        center.add(sqlPanel, BorderLayout.NORTH);
        center.add(resultScroll, BorderLayout.CENTER);
        rightPanel.add(center, BorderLayout.CENTER);

        workPanel.add(leftPanel, BorderLayout.WEST);
        workPanel.add(rightPanel, BorderLayout.CENTER);
        root.add(workPanel, BorderLayout.CENTER);

        statusLabel = new JLabel("Not connected");
        root.add(statusLabel, BorderLayout.SOUTH);

        connectButton.addActionListener(e -> connect());
        disconnectButton.addActionListener(e -> disconnect());
        tableCombo.addActionListener(e -> loadColumns());
        selectAllButton.addActionListener(e -> columnList.setSelectionInterval(
                0, Math.max(0, columnList.getModel().getSize() - 1)));
        buildButton.addActionListener(e -> buildSelectQuery());
        executeButton.addActionListener(e -> executeQuery());
    }

    private void addGrid(JPanel panel, GridBagConstraints c, int x, int y, Component component) {
        c.gridx = x;
        c.gridy = y;
        c.weightx = (component instanceof JTextField || component instanceof JPasswordField) ? 1 : 0;
        panel.add(component, c);
    }

    // private void connect() {
        // String url = urlField.getText().trim();
        // String user = userField.getText().trim();
        // String password = new String(passwordField.getPassword());

        // if (url.isEmpty()) {
            // showError("Enter a JDBC URL.");
            // return;
        // }

        // try {
            // disconnectQuietly();
            // if (user.isEmpty()) {
                // connection = DriverManager.getConnection(url);
            // } else {
                // connection = DriverManager.getConnection(url, user, password);
            // }
            // metadata = connection.getMetaData();
            // loadTables();
            // connectButton.setEnabled(false);
            // disconnectButton.setEnabled(true);
            // statusLabel.setText("Connected: " + metadata.getDatabaseProductName()
                    // + " " + metadata.getDatabaseProductVersion());
        // } catch (SQLException ex) {
            // disconnectQuietly();
            // showError("Connection failed: " + ex.getMessage());
        // }
    // }
	
	private void connect() {
    String url = urlField.getText().trim();
    String user = userField.getText().trim();
    String password = new String(passwordField.getPassword());

    if (url.isEmpty()) {
        showError("Enter a JDBC URL.");
        return;
    }

    try {
        disconnectQuietly();

        // Connect to Oracle using JDBC
        Class.forName("oracle.jdbc.OracleDriver");

        connection = DriverManager.getConnection(
            url,
            user,
            password
        );

        metadata = connection.getMetaData();

        loadTables();

        connectButton.setEnabled(false);
        disconnectButton.setEnabled(true);

        statusLabel.setText(
            "Connected: " +
            metadata.getDatabaseProductName() + " " +
            metadata.getDatabaseProductVersion()
        );

    } catch (ClassNotFoundException ex) {
        showError("Oracle JDBC Driver not found. Add ojdbc JAR to your project.");

    } catch (SQLException ex) {
        disconnectQuietly();
        showError("Connection failed: " + ex.getMessage());
    }
}

    private void loadTables() throws SQLException {
        tableCombo.removeAllItems();
        String catalog = connection.getCatalog();
        try (ResultSet rs = metadata.getTables(catalog, null, "%", new String[]{"TABLE", "VIEW"})) {
            while (rs.next()) {
                tableCombo.addItem(new TableInfo(
                        rs.getString("TABLE_CAT"),
                        rs.getString("TABLE_SCHEM"),
                        rs.getString("TABLE_NAME"),
                        rs.getString("TABLE_TYPE")));
            }
        }
        if (tableCombo.getItemCount() == 0) {
            columnList.setListData(new String[0]);
            statusLabel.setText("Connected, but no tables or views were found.");
        }
    }

    private void loadColumns() {
        if (connection == null || tableCombo.getSelectedItem() == null) return;
        TableInfo table = (TableInfo) tableCombo.getSelectedItem();
        List<String> columns = new ArrayList<>();
        try (ResultSet rs = metadata.getColumns(table.catalog, table.schema, table.name, "%")) {
            while (rs.next()) columns.add(rs.getString("COLUMN_NAME"));
            columnList.setListData(columns.toArray(new String[0]));
            if (!columns.isEmpty()) columnList.setSelectionInterval(0, columns.size() - 1);
        } catch (SQLException ex) {
            showError("Could not load columns: " + ex.getMessage());
        }
    }

    private void buildSelectQuery() {
        if (connection == null) {
            showError("Connect to a database first.");
            return;
        }
        TableInfo table = (TableInfo) tableCombo.getSelectedItem();
        if (table == null) {
            showError("Select a table first.");
            return;
        }

        List<String> selected = columnList.getSelectedValuesList();
        StringBuilder sql = new StringBuilder("SELECT ");
        if (selected.isEmpty()) {
            sql.append("*");
        } else {
            for (int i = 0; i < selected.size(); i++) {
                if (i > 0) sql.append(", ");
                sql.append(quoteIdentifier(selected.get(i)));
            }
        }
        sql.append(" FROM ").append(qualifiedTableName(table));

        String where = whereField.getText().trim();
        if (!where.isEmpty()) sql.append(" WHERE ").append(where);

        String order = orderByField.getText().trim();
        if (!order.isEmpty()) sql.append(" ORDER BY ").append(order);

        sql.append(";");
        sqlArea.setText(sql.toString());
    }

    private String qualifiedTableName(TableInfo table) {
        StringBuilder name = new StringBuilder();
        if (table.schema != null && !table.schema.trim().isEmpty()) {
            name.append(quoteIdentifier(table.schema)).append(".");
        }
        name.append(quoteIdentifier(table.name));
        return name.toString();
    }

    private String quoteIdentifier(String identifier) {
        if (metadata == null) return identifier;
        try {
            String quote = metadata.getIdentifierQuoteString();
            if (quote == null || quote.trim().isEmpty()) return identifier;
            return quote + identifier.replace(quote, quote + quote) + quote;
        } catch (SQLException ex) {
            return identifier;
        }
    }

    private void executeQuery() {
        if (connection == null) {
            showError("Connect to a database first.");
            return;
        }
        String sql = sqlArea.getText().trim();
        if (sql.isEmpty()) {
            showError("Enter or build a SQL query first.");
            return;
        }

        try (Statement statement = connection.createStatement()) {
            boolean hasResult = statement.execute(sql);
            if (hasResult) {
                try (ResultSet rs = statement.getResultSet()) {
                    showResultSet(rs);
                }
            } else {
                int count = statement.getUpdateCount();
                resultTable.setModel(new DefaultTableModel());
                statusLabel.setText("Command completed. Rows affected: " + count);
            }
        } catch (SQLException ex) {
            showError("SQL error: " + ex.getMessage());
        }
    }

    private void showResultSet(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        String[] names = new String[columnCount];
        for (int i = 1; i <= columnCount; i++) names[i - 1] = rsmd.getColumnLabel(i);

        DefaultTableModel model = new DefaultTableModel(names, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        int rows = 0;
        while (rs.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) row[i - 1] = rs.getObject(i);
            model.addRow(row);
            rows++;
        }
        resultTable.setModel(model);
        statusLabel.setText("Query successful. Rows returned: " + rows);
    }

    private void disconnect() {
        disconnectQuietly();
        tableCombo.removeAllItems();
        columnList.setListData(new String[0]);
        resultTable.setModel(new DefaultTableModel());
        connectButton.setEnabled(true);
        disconnectButton.setEnabled(false);
        statusLabel.setText("Not connected");
    }

    private void disconnectQuietly() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ignored) {
                // Ignore close errors.
            }
            connection = null;
            metadata = null;
        }
    }

    private void showError(String message) {
        statusLabel.setText(message);
        JOptionPane.showMessageDialog(this, message, "Query01", JOptionPane.ERROR_MESSAGE);
    }

    private static class TableInfo {
        final String catalog;
        final String schema;
        final String name;
        final String type;

        TableInfo(String catalog, String schema, String name, String type) {
            this.catalog = catalog;
            this.schema = schema;
            this.name = name;
            this.type = type;
        }

        @Override
        public String toString() {
            return (schema == null || schema.trim().isEmpty() ? "" : schema + ".") + name
                    + " (" + type + ")";
        }
    }

    @Override
    public void dispose() {
        disconnectQuietly();
        super.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Query01().setVisible(true));
    }
}
