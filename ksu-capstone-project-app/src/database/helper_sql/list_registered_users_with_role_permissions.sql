select ru.RegisteredUserId,
	   ru.LastName,
       ru.FirstName,
       ru.FamilyId,
       ru.LoginUserId,
       ru.Password,
       ur.Role,
       rp.Application,
       rp.PermissionSetting
from `familydonations`.`RegisteredUser` ru
	join `familydonations`.`RegisteredUserRoles` rur on ru.RegisteredUserId = rur.RegisteredUserId 
    join `familydonations`.`UserRole` ur on rur.UserRoleId = ur.UserRoleId 
    join `familydonations`.`RolePermissions` rp on ur.UserRoleId = rp.UserRoleId
