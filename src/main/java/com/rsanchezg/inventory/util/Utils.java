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
    if (base64Image.contains(",")) {
      base64Image = base64Image.split(",")[1];
    }
    return Base64.getDecoder().decode(base64Image);
  }

}
