# G711A

C++ for G711A coding and decoding（去“吱吱”电流声）

# Usage

G711aEncode(byte[] pcmDataArr, Result result) 方法参数的意义，pcmDataArr 为原始的音频PCM数据，result 为 G711a 的内部静态类，编码后的结果调用 Result 类的 getDataArr 方法。

G711aDecode(byte[] g711DataArr, Result result) 方法参数的意义，g711DataArr 为编码后的PCM音频数据即G711A数据，result 为 G711a 的内部静态类，解码后的结果调用 Result 类的 getDataArr 方法。
