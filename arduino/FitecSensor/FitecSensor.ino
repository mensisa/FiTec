#include <SoftwareSerial.h>
 
int Tx=6; //transport
int Rx=7; //receive
 
SoftwareSerial btSerial(Tx, Rx);
 
void setup() 
{
  Serial.begin(9600);
  btSerial.begin(9600);
}
 
void loop()
{
  if (btSerial.available()) {       
    Serial.write(btSerial.read());
  }
  if (Serial.available()) {         
    btSerial.write(Serial.read());
  }
}
