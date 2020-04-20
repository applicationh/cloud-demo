package param;

import java.util.Date;
import java.io.Serializable;

/**
 * 角色-权限关联表(SysRolePermission)参数类
 *
 * @author wsh
 * 
 */
public class SysRolePermissionParam implements Serializable {
    private static final long serialVersionUID = -21470957284722937L;

        
    private Integer id;
        
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}