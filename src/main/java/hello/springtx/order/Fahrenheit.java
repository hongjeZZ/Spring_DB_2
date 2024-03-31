package hello.springtx.order;

class Fahrenheit {
    float fahrenheit = (float) 43.2;

    float convertToCelsius() {
        float celsius = ((float) 5 / 9) * (fahrenheit - 32);
        return celsius;
    }

    public static void main(String[] args) {
        Fahrenheit fahrenheit = new Fahrenheit();
        float celsius = fahrenheit.convertToCelsius();
        System.out.printf("화씨 43.2도는 섭씨 %.1f도 입니다", celsius);
    }
}