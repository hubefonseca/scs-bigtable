package scs.demos.pingpong;

/**
* scs/demos/pingpong/PingPongHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/pingPong.idl
* Saturday, December 6, 2008 5:21:18 PM BRST
*/

public final class PingPongHolder implements org.omg.CORBA.portable.Streamable
{
  public scs.demos.pingpong.PingPong value = null;

  public PingPongHolder ()
  {
  }

  public PingPongHolder (scs.demos.pingpong.PingPong initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = scs.demos.pingpong.PingPongHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    scs.demos.pingpong.PingPongHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return scs.demos.pingpong.PingPongHelper.type ();
  }

}
