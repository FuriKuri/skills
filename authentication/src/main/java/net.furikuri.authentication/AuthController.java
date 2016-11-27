package net.furikuri.authentication;

import com.auth0.jwt.JWTSigner;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class AuthController {

  private final String secret = "secret";
  private final String issuer = "skills.auth";
  private final JWTSigner signer = new JWTSigner(secret);

  @RequestMapping(
    value = "/auth",
    method = RequestMethod.POST,
    consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE},
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE
  )
  public Token authJson(@RequestBody Auth auth) {
    return new Token(createToken(auth.getUser()));
  }

  @RequestMapping(
    value = "/auth",
    method = RequestMethod.POST,
    consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE},
    produces = MediaType.TEXT_PLAIN_VALUE
  )
  public String authForm(@RequestParam("user") String user, @RequestParam("password") String password) {
    return createToken(user);
  }

  private String createToken(String user) {
    long iat = System.currentTimeMillis() / 1000L;
    long exp = iat + 60L * 60L;

    HashMap<String, Object> claims = new HashMap<>();
    claims.put("iss", issuer);
    claims.put("exp", exp);
    claims.put("iat", iat);
    claims.put("user", user);

    return signer.sign(claims);
  }
}
