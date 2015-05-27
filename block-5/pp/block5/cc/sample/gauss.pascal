Program gauss;

Function gauss(n: Integer): Integer;
    Begin
        If n <= 1
        Then gauss := n
        Else gauss := n + gauss(n-1)
    End;

Var arg, result: Integer;
Begin
    In("Upper bound? ", arg);
    result := gauss(arg);
    Out("Result: ", result)
End.
