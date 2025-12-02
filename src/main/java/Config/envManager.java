package Config;

import java.util.Map;

public class envManager {


    public class EnvManager {
        // Simple environment manager - map environment name to base URL and other env-specific properties
        private final Map<String, String> envs = Map.of(
                "dev", "https://dev.atl.com",
                "qa", "https://qa.atl.com",
                "trng", "https://trng.www.atl.com"
        );


        public String getBaseUrl(String env) {
            return envs.getOrDefault(env, envs.get("dev"));
        }
    }
}