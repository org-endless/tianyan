#!/bin/bash

# 设置要搜索的目录和输出文件
DIRECTORY="../../gycdp-server"
OUTPUT="../../cd/sql/merged_ddl.sql"

# 删除旧的输出文件（如果存在）
if [ -f "$OUTPUT" ]; then
  rm "$OUTPUT"
fi

# 遍历所有 .ddl.sql 文件并按文件名排序
find "$DIRECTORY" -type f -name "*.ddl.sql" | sort | while read -r file; do
  echo "-- File: $(basename "$file")" >> "$OUTPUT"
  cat "$file" >> "$OUTPUT"
  echo "" >> "$OUTPUT"
done

echo "所有 DDL 文件已合并到: $OUTPUT"

# 设置要搜索的目录和输出文件
DIRECTORY="../../gycdp-server"
OUTPUT="../../cd/sql/merged_dml.sql"

# 删除旧的输出文件（如果存在）
if [ -f "$OUTPUT" ]; then
  rm "$OUTPUT"
fi

# 遍历所有 .ddl.sql 文件并按文件名排序
find "$DIRECTORY" -type f -name "*.dml.sql" | sort | while read -r file; do
  echo "-- File: $(basename "$file")" >> "$OUTPUT"
  cat "$file" >> "$OUTPUT"
  echo "" >> "$OUTPUT"
done

echo "所有 DDL 文件已合并到: $OUTPUT"
