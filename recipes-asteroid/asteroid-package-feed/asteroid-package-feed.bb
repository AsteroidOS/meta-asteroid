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

do_package_index[nostamp] = "1"
do_package_index[depends] += "${PACKAGEINDEXDEPS}"
do_package_index[depends] += "${@oe.utils.build_depends_string(d.getVar('PACKAGE_FEED'), 'do_package_write_ipk')}"

python do_package_index() {
    from oe.rootfs import generate_index_files
    generate_index_files(d)
}
addtask do_package_index before do_build
EXCLUDE_FROM_WORLD = "1"
