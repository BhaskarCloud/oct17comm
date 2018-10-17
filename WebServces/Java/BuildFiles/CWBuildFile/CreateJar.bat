setlocal
set var1=dist\%~n1.jar
echo %var1%
set var2=Scripts.%~n1
echo %var2%
"C:\Program Files\Java\jdk1.7.0_67\bin\jar" cvfe %var1% %var2% -C ./classes/ .

