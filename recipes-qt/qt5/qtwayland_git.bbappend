FILESEXTRAPATHS_prepend := "${THISDIR}/qtwayland:"
SRC_URI += " file://0001-Forces-GLES2-the-dirty-way.patch \
             file://0002-Add-a-mechanism-to-delay-unmapping-of-surfaces.patch \
             file://0003-QWlExtendedOutput-specify-resource-s-version-when-cr.patch "
