package example.functionality.secrret_key_generator;

import org.springframework.cache.interceptor.KeyGenerator;

import java.security.SecureRandom;
import java.util.Base64;

public class SecretKeyGenerator {

    public static String generateSecretKey(int lenght) {
        // массив байтов для хранения ключа
        byte[] key = new byte[lenght];

        // криптографический безопасный генератор случайных чисел
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(key);

        // возвращаем ключ в формате Base64
        return Base64.getEncoder().encodeToString(key);
    }
}
