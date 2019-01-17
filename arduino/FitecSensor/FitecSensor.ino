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
