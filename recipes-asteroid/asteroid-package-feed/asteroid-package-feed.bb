SUMMARY = "Create a package index from the packages included in rootfs and community packages."
LICENSE = "MIT"

INHIBIT_DEFAULT_DEPS = "1"
PACKAGES = ""

# A set of packages to build for the package feed but that are not included in rootfs.
PACKAGE_FEED ?= ""

inherit nopackages

deltask do_fetch
deltask do_unpack
deltask do_patch
deltask do_configure
deltask do_compile
deltask do_install
deltask do_populate_lic
deltask do_populate_sysroot

def get_package_feed_depends(d):
    tasks = d.getVar("SSTATETASKS").split()
    package_feed = d.getVar('PACKAGE_FEED')
    return " ".join(oe.utils.build_depends_string(package_feed, task) for task in tasks)

do_package_index[nostamp] = "1"
do_package_index[depends] += "${PACKAGEINDEXDEPS}"
do_package_index[depends] += "${@get_package_feed_depends(d)}"

python do_package_index() {
    from oe.rootfs import generate_index_files
    generate_index_files(d)
}
addtask do_package_index before do_build
EXCLUDE_FROM_WORLD = "1"
