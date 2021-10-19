require gcc8-${PV}.inc
require libgcc8.inc

# Building with thumb enabled on armv6t fails
ARM_INSTRUCTION_SET:armv6 = "arm"
