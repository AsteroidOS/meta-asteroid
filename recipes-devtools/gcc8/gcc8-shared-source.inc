do_fetch() {
	:
}
do_fetch[noexec] = "1"
deltask do_unpack
deltask do_patch

SRC_URI = ""

do_configure[depends] += "gcc8-source-${PV}:do_preconfigure"
do_populate_lic[depends] += "gcc8-source-${PV}:do_unpack"
