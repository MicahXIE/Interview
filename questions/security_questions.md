1. what is the difference between hashing and encryption.
散列是一种单向算法； 不可逆转
加密是可逆的，但需要"秘密"进行

2. symmetric and asymmetric cryptography.
对称加密是最快速、最简单的一种加密方式，加密（encryption）与解密（decryption）用的是同样的密钥（secret key）,这种方法在密码学中叫做对称加密算法。
非对称密钥加密，它需要使用“一对”密钥来分别完成加密和解密操作，一个公开发布，即公开密钥，另一个由用户自己秘密保存，即私用密钥。信息发送者用公开密钥去加密，而信息接收者则用私用密钥去解密。公钥机制灵活，但加密和解密速度却比对称密钥加密慢得多。（ssh 属于哪种加密）