package scs.demos.bigtable;


/**
* scs/demos/bigtable/AllEntriesHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/bigTable.idl
* Saturday, December 13, 2008 1:04:31 PM BRST
*/

abstract public class AllEntriesHelper
{
  private static String  _id = "IDL:scs/demos/bigtable/AllEntries:1.0";

  public static void insert (org.omg.CORBA.Any a, scs.demos.bigtable.Entries[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static scs.demos.bigtable.Entries[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = scs.demos.bigtable.EntriesHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (scs.demos.bigtable.AllEntriesHelper.id (), "AllEntries", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static scs.demos.bigtable.Entries[] read (org.omg.CORBA.portable.InputStream istream)
  {
    scs.demos.bigtable.Entries value[] = null;
    int _len0 = istream.read_long ();
    value = new scs.demos.bigtable.Entries[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = scs.demos.bigtable.EntriesHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, scs.demos.bigtable.Entries[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      scs.demos.bigtable.EntriesHelper.write (ostream, value[_i0]);
  }

}