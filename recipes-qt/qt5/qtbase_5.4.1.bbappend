# Remove dependencies to mesa
PACKAGECONFIG_remove = "kms"
PACKAGECONFIG_remove = "gl"
PACKAGECONFIG_remove = "gles2"
PACKAGECONFIG_append = "mtdev"
PACKAGECONFIG_append = "linuxfb"
