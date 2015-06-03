Program fib;

Function fib(n: Integer): Integer;
    Begin
        If n <= 1
        Then fib := 1
        Else fib := fib(n-2) + fib(n-1)
    End;

Var arg, result: Integer;
Begin
    In("Argument? ", arg);
    result := fib(arg);
    Out("Result: ", result)
End.
