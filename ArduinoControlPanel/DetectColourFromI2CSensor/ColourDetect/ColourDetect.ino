//void setup() {
  // put your setup code here, to run once:
  //I2C Sensore Address 0x52
//    }

//void loop() {
  // put your main code here, to run repeatedly:

//}


#include <Wire.h>
int ADXLAddress = 0x52; // Device address in which is also included the 8th bit for selecting the mode, read in this case.
#define X_Axis_Register_DATAX0 0x32 // Hexadecima address for the DATAX0 internal register.
#define X_Axis_Register_DATAX1 0x33 // Hexadecima address for the DATAX1 internal register.
#define Power_Register 0x2D // Power Control Register

void setup() {
  Wire.begin(); // Initiate the Wire library
  Serial.begin(9600);
  delay(100);
  // Enable measurement
  Wire.beginTransmission(ADXLAddress);
  //Wire.write(Power_Register);
  // Bit D3 High for measuring enable (0000 1000)
  //Wire.write(8);  
  //Wire.endTransmission();
}
void loop() {
  Serial.print("READ = " + Wire.Read );
}
