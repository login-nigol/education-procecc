package example.functionality.secrret_key_generator;

public class SecretKeyApp {
    public static void main(String[] args) {

        SecretKeyGenerator keyGenerator = new SecretKeyGenerator();

        // генерация ключа длиной 32 байта (256 бит)
        String secretKey = SecretKeyGenerator.generateSecretKey(64);

        System.out.println("Ваш секретный ключ:\n" + secretKey);
    }
}
