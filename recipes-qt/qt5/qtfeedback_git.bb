require qt5.inc
require qt5-git.inc

QT_MODULE_BRANCH = "master"
LICENSE = "GFDL-1.3 & (LGPL-2.1 & The-Qt-Company-Qt-LGPL-Exception-1.1) | GPL-2.0"
LIC_FILES_CHKSUM = " \
    file://LICENSE.FDL;md5=6d9f2a9af4c8b8c3c769f6cc1b6aaf7e \
    file://LICENSE.LGPLv21;md5=4193e7f1d47a858f6b7c0f1ee66161de \
    file://LICENSE.GPLv3;md5=d32239bcb673463ab874e80d47fae504 \
    file://LGPL_EXCEPTION.txt;md5=0145c4d1b6f96a661c2c139dfb268fb6 \
"

DEPENDS += "qtbase qtdeclarative"

SRCREV = "28ca62414901502189ea28ef2efd551386187619"
