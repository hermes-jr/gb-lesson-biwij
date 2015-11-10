5 REM This file is for testing
10 LET a=2
20 LET b=1
30 LET c=5
40 LET d=b*b-4*a*c
50 IF d>0 THEN GOTO 100
60 IF d=0 THEN GOTO 200
70 PRINT "No roots"
80 GOTO 300
100 LET x1=(-b+Math.sqrt(d))/2/a
110 LET x2=(-b+Math.sqrt(d))/2/a
120 PRINT "x1=";
130 PRINT x1
140 PRINT "x2=";
150 PRINT x2
160 GOTO 300
200 PRINT "x=";
210 PRINT -b/2/a
300 PRINT "Program finished"
