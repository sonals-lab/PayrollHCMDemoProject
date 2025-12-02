package Config;

import java.util.Map;
import java.util.Set;

public class roleConfig {

    public class RoleConfig {
        // Hard-coded role -> permission mapping for demo. In real projects this can come from JSON or DB.
        private final Map<String, Set<String>> rolePermissions = Map.of(
                "Admin", Set.of("read:any", "write:any", "delete:any"),
                "HR", Set.of("read:employees", "run:payroll"),
                "Manager", Set.of("approve:timeoff", "view:reports"),
                "Employee", Set.of("read:self", "submit:timeoff")
        );


        public boolean hasPermission(String role, String permission) {
            return rolePermissions.getOrDefault(role, Set.of()).contains(permission);
        }


    }

}
