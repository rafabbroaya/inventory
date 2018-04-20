package com.rsanchezg.inventory.util;

import java.util.Base64;

/**
 * @author raasanch
 */
public final class Utils {

  private Utils() {
  }

  public static String encodeImageBase64(byte[] image) {
    if (image != null) {
      byte[] encode = Base64.getEncoder().encode(image);
      return new String(encode);
    }
    return null;
  }

  public static byte[] decodeImageBase64(String base64Image) {
    if (base64Image == null || "".equalsIgnoreCase(base64Image)) {
      return null;
    }
    return Base64.getDecoder().decode(base64Image);
  }

}
