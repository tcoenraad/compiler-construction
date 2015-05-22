Program gcd;

Var x, y: Integer;

Begin
    In("x? ", x);
    In("y? ", y);
    While x <> y Do
    Begin
        If x > y
        Then x := x-y
        Else y := y-x
    End;
    Out("Greatest common divisor: ", x)
End.
