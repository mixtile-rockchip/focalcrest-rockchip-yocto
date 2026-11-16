# SPDX-License-Identifier: MIT
# Copyright (c) 2026 Focalcrest

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

DEPENDS:append:focalcrest-rk3568 = " xxd-native"
DEPENDS:append:focalcrest-rk3588 = " xxd-native"

SRC_URI:append:edge2 = " \
    file://rk3568-mixtile-edge2.dts \
    file://rk3568-mixtile-edge2-u-boot.dtsi \
    file://rk3568-mixtile-edge2_defconfig \
    file://rk3568-mixtile-edge2.env \
"

do_configure:prepend:edge2() {
	install -m 0644 ${UNPACKDIR}/rk3568-mixtile-edge2.dts \
		${S}/arch/arm/dts/
	install -m 0644 ${UNPACKDIR}/rk3568-mixtile-edge2-u-boot.dtsi \
		${S}/arch/arm/dts/
	install -m 0644 ${UNPACKDIR}/rk3568-mixtile-edge2_defconfig \
		${S}/configs/
	install -d ${S}/board/focalcrest/edge2
	install -m 0644 ${UNPACKDIR}/rk3568-mixtile-edge2.env \
		${S}/board/focalcrest/edge2/
}

SRC_URI:append:blade3 = " \
    file://rk3588-mixtile-blade3.dts \
    file://rk3588-mixtile-blade3-u-boot.dtsi \
    file://rk3588-mixtile-blade3_defconfig \
    file://rk3588-mixtile-blade3.env \
"

do_configure:prepend:blade3() {
	install -m 0644 ${UNPACKDIR}/rk3588-mixtile-blade3.dts \
		${S}/arch/arm/dts/
	install -m 0644 ${UNPACKDIR}/rk3588-mixtile-blade3-u-boot.dtsi \
		${S}/arch/arm/dts/
	install -m 0644 ${UNPACKDIR}/rk3588-mixtile-blade3_defconfig \
		${S}/configs/
	install -d ${S}/board/focalcrest/blade3
	install -m 0644 ${UNPACKDIR}/rk3588-mixtile-blade3.env \
		${S}/board/focalcrest/blade3/
}

SRC_URI:append:core3588e = " \
    file://rk3588-mixtile-core3588e.dts \
    file://rk3588-mixtile-core3588e-u-boot.dtsi \
    file://rk3588-mixtile-core3588e_defconfig \
    file://rk3588-mixtile-core3588e.env \
"

do_configure:prepend:core3588e() {
	install -m 0644 ${UNPACKDIR}/rk3588-mixtile-core3588e.dts \
		${S}/arch/arm/dts/
	install -m 0644 ${UNPACKDIR}/rk3588-mixtile-core3588e-u-boot.dtsi \
		${S}/arch/arm/dts/
	install -m 0644 ${UNPACKDIR}/rk3588-mixtile-core3588e_defconfig \
		${S}/configs/
	install -d ${S}/board/focalcrest/core3588e
	install -m 0644 ${UNPACKDIR}/rk3588-mixtile-core3588e.env \
		${S}/board/focalcrest/core3588e/
}
