/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.bdcor.datserver.filetrans.avro.proto;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public interface datFileTrans {
  public static final org.apache.avro.Protocol PROTOCOL = org.apache.avro.Protocol.parse("{\"protocol\":\"datFileTrans\",\"namespace\":\"com.bdcor.datserver.filetrans.avro.proto\",\"types\":[{\"type\":\"record\",\"name\":\"FileData\",\"fields\":[{\"name\":\"paramsMap\",\"type\":{\"type\":\"map\",\"values\":\"string\"}},{\"name\":\"fileBytes\",\"type\":\"bytes\"}]},{\"type\":\"record\",\"name\":\"HandleResult\",\"fields\":[{\"name\":\"resultType\",\"type\":\"string\"},{\"name\":\"resultStr\",\"type\":\"string\"}]}],\"messages\":{\"convert\":{\"request\":[{\"name\":\"fileData\",\"type\":\"FileData\"}],\"response\":\"HandleResult\"}}}");
  /**
   */
  com.bdcor.datserver.filetrans.avro.proto.HandleResult convert(com.bdcor.datserver.filetrans.avro.proto.FileData fileData) throws org.apache.avro.AvroRemoteException;

  @SuppressWarnings("all")
  public interface Callback extends datFileTrans {
    public static final org.apache.avro.Protocol PROTOCOL = com.bdcor.datserver.filetrans.avro.proto.datFileTrans.PROTOCOL;
    /**
     * @throws java.io.IOException The async call could not be completed.
     */
    void convert(com.bdcor.datserver.filetrans.avro.proto.FileData fileData, org.apache.avro.ipc.Callback<com.bdcor.datserver.filetrans.avro.proto.HandleResult> callback) throws java.io.IOException;
  }
}