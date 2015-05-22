Program gcd;

Var x: Integer;
    i: Integer;
    stop: Boolean;
    
Begin
    In("Number? ", x);
    i := 2;
    stop := false;
    While Not stop And i*i < x Do
    Begin
        stop := i * (x/i) = x;
        i := i+1
    End;
    If stop
    Then Out("Divisor: ", i-1)
    Else Out("Is prime ", stop)
End.
