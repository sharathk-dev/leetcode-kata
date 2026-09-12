#!/usr/bin/env bash
# Reset one or more kata implementations back to their original blank stub,
# so you can practice the same problem again from scratch.
#
# Usage:
#   scripts/reset.sh dev/sharathk/leetcode/TwoSum.java
#   scripts/reset.sh dev/sharathk/leetcode/TwoSum.java dev/sharathk/leetcode/BuyStockSellStock.java
#   scripts/reset.sh --all
#
# Paths are relative to src/main/java. Pristine copies live under stubs/,
# which mirrors that same layout.
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
STUB_DIR="$ROOT_DIR/stubs"
SRC_DIR="$ROOT_DIR/src/main/java"

usage() {
    echo "Usage: $0 <path/to/File.java> [more files...]"
    echo "       $0 --all"
    echo
    echo "Paths are relative to src/main/java, e.g.:"
    echo "  $0 dev/sharathk/leetcode/TwoSum.java"
    echo "  $0 dev/sharathk/leetcode/TwoSum.java dev/sharathk/leetcode/BuyStockSellStock.java"
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

for rel in "$@"; do
    stub="$STUB_DIR/$rel"
    target="$SRC_DIR/$rel"
    if [ ! -f "$stub" ]; then
        echo "no stub found for $rel" >&2
        exit 1
    fi
    cp "$stub" "$target"
    echo "reset $rel"
done
