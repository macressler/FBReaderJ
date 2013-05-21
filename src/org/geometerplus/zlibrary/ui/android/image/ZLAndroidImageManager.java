/*
 * Copyright (C) 2007-2013 Geometer Plus <contact@geometerplus.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */

package org.geometerplus.zlibrary.ui.android.image;

import org.geometerplus.fbreader.formats.PluginImage;
import org.geometerplus.zlibrary.core.util.MimeType;
import org.geometerplus.zlibrary.core.image.*;

public final class ZLAndroidImageManager extends ZLImageManager {
	@Override
	public ZLAndroidImageData getImageData(ZLImage image) {
		if (image instanceof PluginImage) {
			final ZLBitmapImage bitmapImage = (ZLBitmapImage)(((PluginImage)image).getRealImage());
			return new BitmapImageData(bitmapImage);
		} else if (image instanceof ZLSingleImage) {
			final ZLSingleImage singleImage = (ZLSingleImage)image;
			if (MimeType.IMAGE_PALM.equals(singleImage.mimeType())) {
				return null;
			}
			return new InputStreamImageData(singleImage);
		}
		return null;
	}

	private ZLAndroidImageLoader myLoader;

	@Override
	protected void startImageLoading(ZLLoadableImage image, Runnable postLoadingRunnable) {
		if (myLoader == null) {
			myLoader = new ZLAndroidImageLoader();
		}
		myLoader.startImageLoading(image, postLoadingRunnable);
	}
}
