import os
import re
import subprocess
from datetime import datetime, timezone

# ============================================================
# JavaSquadz README Auto Updater
# ============================================================

ROOT_DIR = os.path.abspath(os.path.join(os.path.dirname(__file__), "../.."))
README_FILE = os.path.join(ROOT_DIR, "README.md")

# Folders/files that should not appear in the repository tree
IGNORED_NAMES = {
    ".git",
    ".github",
    ".gitignore",
    ".gitattributes",
    ".idea",
    ".vscode",
    "node_modules",
    "__pycache__",
}

# Maximum depth displayed in README
MAX_DEPTH = 5


# ============================================================
# Repository Statistics
# ============================================================

def get_statistics():
    java_files = 0
    total_files = 0
    folders = 0

    for root, dirs, files in os.walk(ROOT_DIR):

        dirs[:] = [
            d for d in dirs
            if d not in IGNORED_NAMES
            and not d.startswith(".")
        ]

        for file in files:

            if file in IGNORED_NAMES:
                continue

            if file.startswith("."):
                continue

            total_files += 1

            if file.lower().endswith(".java"):
                java_files += 1

        folders += len(dirs)

    return java_files, total_files, folders


# ============================================================
# Repository Tree Generator
# ============================================================

def build_tree(directory, prefix="", depth=0):

    if depth > MAX_DEPTH:
        return []

    try:
        entries = os.listdir(directory)
    except PermissionError:
        return []

    entries = [
        entry for entry in entries
        if entry not in IGNORED_NAMES
        and not entry.startswith(".")
    ]

    entries.sort(
        key=lambda x: (
            not os.path.isdir(os.path.join(directory, x)),
            x.lower()
        )
    )

    lines = []

    for index, entry in enumerate(entries):

        path = os.path.join(directory, entry)

        is_last = index == len(entries) - 1

        connector = "└── " if is_last else "├── "
        child_prefix = prefix + ("    " if is_last else "│   ")

        if os.path.isdir(path):

            lines.append(f"{prefix}{connector}{entry}/")

            lines.extend(
                build_tree(
                    path,
                    child_prefix,
                    depth + 1
                )
            )

        else:

            lines.append(
                f"{prefix}{connector}{entry}"
            )

    return lines


def generate_tree():

    lines = ["JavaSquadz/"]

    lines.extend(
        build_tree(ROOT_DIR)
    )

    return "\n".join(lines)


# ============================================================
# Git Information
# ============================================================

def run_git(command):

    try:
        result = subprocess.run(
            command,
            cwd=ROOT_DIR,
            capture_output=True,
            text=True,
            check=True
        )

        return result.stdout.strip()

    except Exception:
        return ""


def get_recent_commits(limit=5):

    output = run_git([
        "git",
        "log",
        f"-{limit}",
        "--pretty=format:%h|%s|%ad",
        "--date=format:%d %b %Y"
    ])

    commits = []

    if not output:
        return commits

    for line in output.splitlines():

        parts = line.split("|", 2)

        if len(parts) == 3:

            commit_hash = parts[0]
            message = parts[1]
            date = parts[2]

            commits.append(
                {
                    "hash": commit_hash,
                    "message": message,
                    "date": date
                }
            )

    return commits


# ============================================================
# Latest Commit
# ============================================================

def get_latest_commit():

    output = run_git([
        "git",
        "log",
        "-1",
        "--pretty=format:%h|%s|%ad",
        "--date=format:%d %b %Y"
    ])

    if not output:
        return {
            "hash": "N/A",
            "message": "Repository update",
            "date": datetime.now().strftime("%d %b %Y")
        }

    parts = output.split("|", 2)

    return {
        "hash": parts[0],
        "message": parts[1],
        "date": parts[2]
    }


# ============================================================
# Latest Updates Section
# ============================================================

def generate_latest_updates():

    commits = get_recent_commits(5)

    latest = get_latest_commit()

    lines = []

    lines.append(
        f"**Last automated update:** `{latest['date']}`"
    )

    lines.append("")

    lines.append("### 🔥 Recent Changes")

    lines.append("")

    if commits:

        for commit in commits:

            message = commit["message"]

            # Prevent README formatting problems
            message = message.replace("`", "'")

            lines.append(
                f"- 📝 `{commit['hash']}` — "
                f"{message} · *{commit['date']}*"
            )

    else:

        lines.append(
            "- 🚀 Repository is being actively developed."
        )

    lines.append("")

    lines.append(
        "> 🤖 This section is automatically generated "
        "from the repository's Git history."
    )

    return "\n".join(lines)


# ============================================================
# Statistics Section
# ============================================================

def generate_statistics():

    java_files, total_files, folders = get_statistics()

    return f"""| 📊 Metric | Count |
|------------|------:|
| ☕ Java Files | **{java_files}** |
| 📄 Total Files | **{total_files}** |
| 📁 Folders | **{folders}** |
"""


# ============================================================
# Replace README Sections
# ============================================================

def replace_section(
    content,
    start_marker,
    end_marker,
    replacement
):

    pattern = (
        re.escape(start_marker)
        + r".*?"
        + re.escape(end_marker)
    )

    replacement_text = (
        start_marker
        + "\n"
        + replacement
        + "\n"
        + end_marker
    )

    new_content, count = re.subn(
        pattern,
        replacement_text,
        content,
        flags=re.DOTALL
    )

    return new_content, count


# ============================================================
# Main
# ============================================================

def main():

    print("========================================")
    print(" JavaSquadz README Auto Updater")
    print("========================================")

    if not os.path.exists(README_FILE):

        print("README.md not found.")

        return

    with open(
        README_FILE,
        "r",
        encoding="utf-8"
    ) as file:

        readme = file.read()

    # --------------------------------------------------------
    # Generate content
    # --------------------------------------------------------

    tree = generate_tree()

    latest_updates = generate_latest_updates()

    statistics = generate_statistics()

    # --------------------------------------------------------
    # Update Repository Structure
    # --------------------------------------------------------

    readme, count_tree = replace_section(
        readme,
        "<!-- REPO_STRUCTURE_START -->",
        "<!-- REPO_STRUCTURE_END -->",
        f"```text\n{tree}\n```"
    )

    # --------------------------------------------------------
    # Update Latest Updates
    # --------------------------------------------------------

    readme, count_updates = replace_section(
        readme,
        "<!-- LATEST_UPDATES_START -->",
        "<!-- LATEST_UPDATES_END -->",
        latest_updates
    )

    # --------------------------------------------------------
    # Update Statistics
    # --------------------------------------------------------

    readme, count_stats = replace_section(
        readme,
        "<!-- REPO_STATS_START -->",
        "<!-- REPO_STATS_END -->",
        statistics
    )

    # --------------------------------------------------------
    # Write README
    # --------------------------------------------------------

    with open(
        README_FILE,
        "w",
        encoding="utf-8"
    ) as file:

        file.write(readme)

    print("")
    print("README update completed.")
    print(f"Repository Structure updated: {count_tree}")
    print(f"Latest Updates updated:       {count_updates}")
    print(f"Statistics updated:           {count_stats}")
    print("")


if __name__ == "__main__":
    main()