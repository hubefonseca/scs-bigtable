package scs.demos.bigtable;


/**
* scs/demos/bigtable/Entries.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/bigTable.idl
* Saturday, December 13, 2008 1:04:31 PM BRST
*/

public final class Entries implements org.omg.CORBA.portable.IDLEntity
{
  public org.omg.CORBA.Any key = null;
  public org.omg.CORBA.Any values[] = null;

  public Entries ()
  {
  } // ctor

  public Entries (org.omg.CORBA.Any _key, org.omg.CORBA.Any[] _values)
  {
    key = _key;
    values = _values;
  } // ctor

} // class Entries