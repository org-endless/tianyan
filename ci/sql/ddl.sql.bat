@echo off
setlocal enabledelayedexpansion

:: 获取当前脚本所在目录
set "BASEDIR=%~dp0"
cd /d "%BASEDIR%"

:: 设置要搜索的目录和输出文件（基于当前脚本位置）
set "DIRECTORY=..\.."
set "DDL_OUTPUT=..\..\cd\sql\merged_ddl.sql"
set "DML_OUTPUT=..\..\cd\sql\merged_dml.sql"

:: 删除旧的输出文件
if exist "%DDL_OUTPUT%" del "%DDL_OUTPUT%"
if exist "%DML_OUTPUT%" del "%DML_OUTPUT%"

:: 合并 DDL 文件
echo 正在合并 DDL 文件...
for /r "%DIRECTORY%" %%f in (*.ddl.sql) do (
    echo -- File: %%~nxf >> "%DDL_OUTPUT%"
    type "%%f" >> "%DDL_OUTPUT%"
    echo. >> "%DDL_OUTPUT%"
)

:: 合并 DML 文件
echo 正在合并 DML 文件...
for /r "%DIRECTORY%" %%f in (*.dml.sql) do (
    echo -- File: %%~nxf >> "%DML_OUTPUT%"
    type "%%f" >> "%DML_OUTPUT%"
    echo. >> "%DML_OUTPUT%"
)

echo 合并完成!
