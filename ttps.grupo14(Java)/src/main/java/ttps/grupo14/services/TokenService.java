package ttps.grupo14.services;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Calendar;
import java.util.Date;

@Service
public class TokenService {

    final static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String generateToken(String username, int segundos) {

        Date exp = getExpiration(new Date(), segundos);

        return Jwts.builder().setSubject(username).signWith(key).setExpiration(exp).compact();
    }

    private static Date getExpiration(Date date, int segundos) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // Configuramos la fecha que se recibe
        calendar.add(Calendar.MILLISECOND, segundos);

        return calendar.getTime();
    }

    public static boolean validateToken(String token) {

        String prefix = "Bearer";
        try {

            if (token.startsWith(prefix)) {
                token = token.substring(prefix.length()).trim();
            }
            
            return true;
        } catch (ExpiredJwtException exp) {
            System.out.println("El Token es valido, pero expiro su tiempo de validez");
            return false;
        } catch (JwtException e) {
            // Algo salio mal en la verificacion
            System.out.println("Error: " + e.getMessage());
            return false;
        }

    }
}