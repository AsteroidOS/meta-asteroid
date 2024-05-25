FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0005-Use-raw-strings-for-regex-with-backslash-char-pair.patch \
            file://0006-Correct-the-order-of-arguments-to-calloc.patch \
            file://0007-Add-correct-preprocessor-arg-to-fix-error.patch \
"

