inherit asteroid-image
DESCRIPTION = "Asteroid image for developers, contains development and debugging tools"
EXTRA_IMAGE_FEATURES += "tools-debug tools-testapps debug-tweaks"

# Add:
#
# - Bluetooth tools to help diagnose and debug Bluetooth problems
# - bash for a more powerful shell, which is useful for development
# - htop for more detailed information about ongoing processes and
#   their resource usage compared to the regular top tool
IMAGE_INSTALL += " \
        packagegroup-tools-bluetooth \
        bash \
        htop \
"
