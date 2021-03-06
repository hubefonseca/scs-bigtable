package scs.demos.bigtable;


/**
* scs/demos/bigtable/ConfigHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/bigTable.idl
* Saturday, December 13, 2008 1:04:31 PM BRST
*/

abstract public class ConfigHelper
{
  private static String  _id = "IDL:scs/demos/bigtable/Config:1.0";

  public static void insert (org.omg.CORBA.Any a, scs.demos.bigtable.Config that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static scs.demos.bigtable.Config extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (scs.demos.bigtable.ConfigHelper.id (), "Config");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static scs.demos.bigtable.Config read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ConfigStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, scs.demos.bigtable.Config value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static scs.demos.bigtable.Config narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof scs.demos.bigtable.Config)
      return (scs.demos.bigtable.Config)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      scs.demos.bigtable._ConfigStub stub = new scs.demos.bigtable._ConfigStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static scs.demos.bigtable.Config unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof scs.demos.bigtable.Config)
      return (scs.demos.bigtable.Config)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      scs.demos.bigtable._ConfigStub stub = new scs.demos.bigtable._ConfigStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
