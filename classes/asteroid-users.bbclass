SUMMARY = "Creates users and groups for AsteroidOS"
inherit useradd

USERADD_PACKAGES = "${PN}"

# Various recipes in meta-asteroid assume that ceres has UID 1000 and GID 1000.
CERES_UID = "1000"
CERES_GID = "1000"

# When adding non-system groups, fixate their group ID to avoid potential
# collisions when the ceres group is created, because otherwise, without
# an explicitly set group ID, the system might just pick ID 1000. But that
# ID is intended to be used for the ceres group.
# Another way would be to just create the ceres group first. However, it is
# cleaner to nail down the non-system group IDs, making their creation and
# ID assignment deterministic.
# (For the system groups, this is not done, since none of the system groups
# require a specific ID, unlike the ceres user group.)
GROUPADD_PARAM:${PN} = "-r system ; -r gps ; -r datetime ; -g 1024 mtp; -g 1050 sailfish-datetime; -g ${CERES_GID} ceres"

USERADD_PARAM:${PN} = "-m -p '' -u ${CERES_UID} -g ${CERES_GID} -G audio,video,system,wheel,gps,sailfish-datetime,datetime,mtp,users,input,tty ceres"
