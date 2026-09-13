#!/usr/bin/env bash
# Reset one or more kata implementations back to their original blank stub,
# so you can practice the same problem again from scratch.
#
# Usage:
#   scripts/reset.sh TwoSum
#   scripts/reset.sh TwoSum ThreeSum
#   scripts/reset.sh dev/sharathk/leetcode/array/TwoSum.java
#   scripts/reset.sh --all
#
# A bare class name is resolved by searching stubs/ for a matching
# <Name>.java. A path (containing "/") is treated as relative to
# src/main/java, mirrored under stubs/.
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
STUB_DIR="$ROOT_DIR/stubs"
SRC_DIR="$ROOT_DIR/src/main/java"

usage() {
    echo "Usage: $0 <Name> [more names...]"
    echo "       $0 <path/to/File.java> [more files...]"
    echo "       $0 --all"
    echo
    echo "e.g.:"
    echo "  $0 TwoSum"
    echo "  $0 TwoSum ThreeSum"
    echo "  $0 dev/sharathk/leetcode/array/TwoSum.java"
    exit 1
}

[ $# -eq 0 ] && usage

if [ "$1" == "--all" ]; then
    find "$STUB_DIR" -name "*.java" | while read -r stub; do
        rel="${stub#"$STUB_DIR"/}"
        cp "$stub" "$SRC_DIR/$rel"
        echo "reset $rel"
    done
    exit 0
fi

# Resolves an argument (bare class name or path/to/File.java) to a path
# relative to stubs/, or exits with an error.
resolve_rel() {
    local arg="$1"

    if [[ "$arg" == */* ]]; then
        if [ ! -f "$STUB_DIR/$arg" ]; then
            echo "no stub found for $arg" >&2
            exit 1
        fi
        echo "$arg"
        return
    fi

    local name="${arg%.java}"
    local matches=()
    while IFS= read -r stub; do
        matches+=("${stub#"$STUB_DIR"/}")
    done < <(find "$STUB_DIR" -name "${name}.java")

    if [ ${#matches[@]} -eq 0 ]; then
        echo "no stub found for $name" >&2
        exit 1
    elif [ ${#matches[@]} -gt 1 ]; then
        echo "ambiguous name $name, matches:" >&2
        printf '  %s\n' "${matches[@]}" >&2
        echo "use a full path to disambiguate" >&2
        exit 1
    fi

    echo "${matches[0]}"
}

for arg in "$@"; do
    rel="$(resolve_rel "$arg")"
    cp "$STUB_DIR/$rel" "$SRC_DIR/$rel"
    echo "reset $rel"
done
