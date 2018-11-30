package com.example.springbootbackendapirest.auth;

public class JwtConfig {
  public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";

  public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\n" +
          "MIIEowIBAAKCAQEAnsJzFKo1zEMP9UHQP+IxCOwzYxygMzw3HgX5B8e7xOsfGvhp\n" +
          "c2VCEsqI9ZYm+gFUKz4Ssp14IBTxgRXv7oMOl7BQGkKKIaFL6VEdZl8sZpaHoUq4\n" +
          "W+LApOJplRxi0rfByIdm+886JVtzB/zpEoUHm8FvzXCgn6oS/4+2Lukxdtm+VnVR\n" +
          "W5AdqlO/N718weu6+b1cMzV/JV4YjaQ/vMXqERoWWog+mjBkjzp+hfJgdBmN+UOD\n" +
          "EYiQe8rBSHiuNPtWwNRdgLN8jaW+4Y2psASUjnCi0CG80eRIcteIb8k10Vk0WJdX\n" +
          "beMwblU+jarMj9WqLtweKJr0BUPNF7C03Bn5iwIDAQABAoIBAARDdJO5fnhd1K/h\n" +
          "dJZCnM6AiWDABA1cMJ69ylJLKt++8LbotOxEa+HVTphJ0AImxvviTt49HFzAMzwk\n" +
          "Oq1NF7c7JOuPneYJTuCVLRTyuV6H7FyIhSryi/nhmrRGbuD5zlp0SG+6wPT/37b3\n" +
          "M8srh2jHaRk7TRT8nEYAtgPMf2eRppW8XcefUwJsyO32h2uOp3kYkX49DcXQ9Kgd\n" +
          "PmGaz02Y0KhsxFYzQWUyGSApIB17ip7Rc6/NGc6ZE1FfvjiCf1mPonwRnmtOQGgL\n" +
          "4lGutdCe88hMBZb9K36ozDDMb7GAbZK/4tgm637MPGVNnI4yWJB8fXCBMlOSH2NC\n" +
          "B4piMQECgYEAz5eDpRJKgnMc0WUjBMyjxm0IujbFbB+ZMQbCqGkANcCIvOeGgcQT\n" +
          "EPr0F8eKixR4Gqu5GGFs/C3JfHeI2/anN6k4UzwWDrocSTZ1DjjHM4AMiSSvRXpF\n" +
          "gi8lo+b88W4SbuJOWsI/wbOqHNcwv/gxfdwR/zYN+nfu0tsHMCESPA8CgYEAw8fS\n" +
          "6DcTL+geATRtd6eY+BOucB+O6LbTrAaa1AD7GX3usbSLhIzdYqQOynzqHuKW9nNZ\n" +
          "Lf8e1hgO9CtBVbKWeBoVoiprB9+oVn9q4aNO6CKkn5jbgDajEVgEGKpzwlxG5+iw\n" +
          "5o5KdzTjr3PbhjhiBqzRZ4exzKP1IQSZ+/F4HsUCgYB+xMLCijHwCYW+pWlGJAWb\n" +
          "Rbg/pvTWe1FcbAlxOHXFXWbjHOu50Nfn1ag74UHMftp9RwKITe507S0OkhyEXtJs\n" +
          "nizkP1wk8CgX2WaQIcIbxAVjtoBGCE3sGwh8V7F9ab9d8Vrx949hpWqrpAmEIXdv\n" +
          "qXVgCU1t99Fi+Bginv94pwKBgGAInbDgix3duxIWOHgQEt3lMZS4Ni56t9vTJZFG\n" +
          "peT8O+CZUjKDsniXRtYWbfUWarybGiyQzvxvsq4cpaC2yE5DZUc1jWjAUd+UAsaJ\n" +
          "h8QgciYDIfCDXHu+c8vxmHTHNNS+9D8znt1YaTMAHrd44sSpctJY4mMiLbSzgCDw\n" +
          "cl6NAoGBAJRXOu5JkTsB9wq83O8CAzy2q/2DFzWajeGNnoMOwERpfWoeSeUX5JEC\n" +
          "+V8MZsH5jXcHVd6pg5m7iAmpBBZkw/MPyN4yuI8GnH07SP92hAwQ6zjqiZTGGyXX\n" +
          "mc90XaEJjg9e0w93Qc+L62MAI8qjiXqAgV/3SZYPkD55X0We/FZG\n" +
          "-----END RSA PRIVATE KEY-----";

  public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\n" +
          "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnsJzFKo1zEMP9UHQP+Ix\n" +
          "COwzYxygMzw3HgX5B8e7xOsfGvhpc2VCEsqI9ZYm+gFUKz4Ssp14IBTxgRXv7oMO\n" +
          "l7BQGkKKIaFL6VEdZl8sZpaHoUq4W+LApOJplRxi0rfByIdm+886JVtzB/zpEoUH\n" +
          "m8FvzXCgn6oS/4+2Lukxdtm+VnVRW5AdqlO/N718weu6+b1cMzV/JV4YjaQ/vMXq\n" +
          "ERoWWog+mjBkjzp+hfJgdBmN+UODEYiQe8rBSHiuNPtWwNRdgLN8jaW+4Y2psASU\n" +
          "jnCi0CG80eRIcteIb8k10Vk0WJdXbeMwblU+jarMj9WqLtweKJr0BUPNF7C03Bn5\n" +
          "iwIDAQAB\n" +
          "-----END PUBLIC KEY-----";
}
