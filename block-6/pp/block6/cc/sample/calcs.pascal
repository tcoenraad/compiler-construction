Program calcs;

Function max(i, j: Integer): Integer;
    Begin
        If i <= j
        Then max := j
        Else max := i
    End;

Function gcd(i, j: Integer): Integer;
    Begin
    	While i <> j Do Begin
    	  If i > j
    	  Then i := i-j
    	  Else j := j-i
    	End;
    	gcd := i
    End;
    
Function isPrime(num: Integer): Boolean;
    Var i: Integer;
        result: Boolean;
    Begin
        i := 2;
        result := true;
        While result And i < num Do Begin
            result := i*(num/i) = num;
            i := i+1
        End;
        isPrime := result
    End;
    
Var arg1, arg2, result: Integer;
Begin
    In("Argument 1? ", arg1);
	If isPrime(arg1)
	Then Out("Is prime: ", arg1);
    In("Argument 2? ", arg2);
    Out("Max: ", max(arg1,arg2));
    Out("GCD: ", gcd(arg1,arg2))
End.
