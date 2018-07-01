package com.andrzejpalys.ModbusProtocolScanner.modbus;

import org.junit.Test;

import static org.junit.Assert.*;

public class ModbusFrameFormatterTest {
   private byte[] errorModbusInputFrame = {0,0,0,0,0,3,1,-126,2};
   private byte[] normalModbusInputFrame = {0,0,0,0,0,5,1,1,2,0,0};

   @Test
   public void is_Modbus_Error_1() {
       assertTrue(ModbusFrameFormatter.isModbusError(errorModbusInputFrame));
   }

   @Test
   public void is_Modbus_Error_2() {
       assertFalse(ModbusFrameFormatter.isModbusError(normalModbusInputFrame));
   }

   @Test
   public void is_No_Modbus_Response_1() {
       assertFalse(ModbusFrameFormatter.isNoModbusResponse(errorModbusInputFrame));
   }

   @Test
   public void is_No_Modbus_Response_2() {
       assertFalse(ModbusFrameFormatter.isNoModbusResponse(normalModbusInputFrame));
   }

   @Test
   public void get_Modbus_Error_Code_1() {
      assertEquals(2, ModbusFrameFormatter.getModbusErrorCode(errorModbusInputFrame));
   }

   @Test
   public void get_Modbus_Error_Name_1() {
       assertEquals("Illegal Data Address", ModbusFrameFormatter.getModbusErrorName(errorModbusInputFrame));
   }
}