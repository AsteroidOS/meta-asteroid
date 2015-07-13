# Remove dependencies to mesa
PACKAGECONFIG_remove = "kms"
PACKAGECONFIG_remove = "gl"
PACKAGECONFIG_append += "gles2 mtdev linuxfb"
