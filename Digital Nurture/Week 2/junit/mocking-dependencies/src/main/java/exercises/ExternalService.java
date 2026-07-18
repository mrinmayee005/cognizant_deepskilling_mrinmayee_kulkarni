package exercises;

import org.springframework.stereotype.Service;

@Service
public class ExternalService {
    public String fetchDataFromExternalAPI(String endpoint) {
        // Simulates calling an external REST API
        return "External data from: " + endpoint;
    }

    public boolean validateWithExternalService(String data) {
        // Simulates validation via external service
        return data != null && !data.isEmpty();
    }
}
