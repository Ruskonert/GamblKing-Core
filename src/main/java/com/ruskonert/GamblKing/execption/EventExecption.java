package com.ruskonert.GamblKing.execption;

public class EventExecption extends RuntimeException
{
    public EventExecption()
    {
        super();
    }

    public EventExecption(String message){ super(message); }

    public EventExecption(Throwable e)
    {
        super(e);
    }
}
