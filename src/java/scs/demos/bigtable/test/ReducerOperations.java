package scs.demos.bigtable.test;


/**
* scs/demos/bigtable/test/ReducerOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../idl/bigTable.idl
* Saturday, December 13, 2008 1:04:31 PM BRST
*/


// nao e pra ser string, string. Isso e so pra testar.
public interface ReducerOperations 
{
  void reduce (String key, String values);
} // interface ReducerOperations