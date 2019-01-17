/*#include <SoftwareSerial.h>
int times;
int rxPin = 3;
int txPin = 2;
SoftwareSerial hc06(rxPin, txPin);

String message; //string that stores the incoming message
char ch;
void setup()
{
 Serial.begin(9600); //set baud rate
 hc06.begin(9600); //set baud rate
}

void loop() {
 // put your main code here, to run repeatedly:
 if(Serial.available())
 {
   ch = Serial.read();
   hc06.write(ch);  
   Serial.write(ch);
 }
if(hc06.available())
 {
   Serial.write(hc06.read());  
 }
}*/

#define TxD 14;
#define RxD 15;
#define BTSerial Serial3;

void setup(){
  Serial.begin(9600);
  Serial3.begin(9600);
}

void loop(){
  if(Serial3.available()){
    Serial.write(Serial3.read());
  }
  if(Serial.available()){
    Serial3.write(Serial.read());
  }
}
